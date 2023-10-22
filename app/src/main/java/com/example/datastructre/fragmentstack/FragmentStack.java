package com.example.datastructre.fragmentstack;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by Dipak Kumar Mehta on 11/30/2022.
 */
public class FragmentStack {

    private static final String TAG = FragmentStack.class.getSimpleName();
    private static FragmentStack instance;
    private HashMap<String, Stack<Fragment>> stackHashMap;

    private FragmentStack() {
        stackHashMap = new HashMap<>();
    }

    public synchronized static FragmentStack getInstance() {
        if (instance == null) {
            instance = new FragmentStack();
        }
        return instance;
    }

    /**
     * Push fragment in fragment stack on specific key
     *
     * @param key      key for fragment stack
     * @param fragment fragment
     */
    private void pushFragmentToStack(String key, Fragment fragment) {
        if (stackHashMap.containsKey(key)) {
            // if key already exist then get stack and push
            stackHashMap.get(key).push(fragment);
        } else {
            // if key not exist then create stack, push key and add to hash map


            Stack<Fragment> stack = new Stack<>();
            stack.push(fragment);
            stackHashMap.put(key, stack);
        }
    }

    /**
     * Get stack item count
     *
     * @param key key for fragment stack
     * @return return 0 or count for specific fragment stack by key
     */
    public int getStackCount(String key) {
        if (stackHashMap == null || !stackHashMap.containsKey(key) || stackHashMap.get(key).empty()) {
            return 0;
        }
        // pop last
        return stackHashMap.get(key).size();
    }

    /**
     * Push fragment
     * (Note: Pass addToBackStack flag false, if stack count is 0 from onBackPressed() method
     * otherwise it will create loop and app will not close)
     *
     * @param activity       activity
     * @param container      container frame layout id
     * @param fragment       fragment
     * @param addToBackStack boolean flag true then add to fragment stack
     * @param key            key for fragment stack
     */
    public void pushFragment(FragmentActivity activity, int container, Fragment fragment, boolean addToBackStack, String key) {
        View view = activity.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)
                    activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
        FragmentManager fm = activity.getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        String tag = fragment.getClass().getSimpleName();

        /*if (fragment instanceof ChatFragment || fragment instanceof AskAgainChatFragment) {
            hideShowBottomNavigation(activity, false);
        } else {
            hideShowBottomNavigation(activity, true);
        }*/

        Log.e(TAG, "pushFragment: " + tag + ", addToBackStack: " + addToBackStack);
        if (addToBackStack) {
            pushFragmentToStack(key, fragment);
        }
        ft.replace(container, fragment, tag);
        ft.commitNowAllowingStateLoss();
    }

    /*public void hideShowBottomNavigation(Activity activity, boolean show) {
        if (activity != null && activity instanceof BottamNavigationActivity) {
            BottamNavigationActivity bottamNavigationActivity = (BottamNavigationActivity) activity;
            bottamNavigationActivity.hideShowNavigation(show);
        }
    }*/

    /**
     * Get last fragment from fragment stack for specific key
     *
     * @param key key for fragment stack
     * @return fragment or null
     */
    public Fragment getLastFragment(String key) {
        if (stackHashMap == null || !stackHashMap.containsKey(key) || stackHashMap.get(key).empty()) {
            return null;
        }
        Fragment fragment = stackHashMap.get(key).pop();
        if (fragment != null) {
            Log.e(TAG, "onBackPressed: " + fragment.getClass().getSimpleName());
        }
        return fragment;
    }


    /**
     * Clear fragment stack by key
     *
     * @param key key for fragment stack
     */
    public void clear(String key) {
        if (stackHashMap == null || !stackHashMap.containsKey(key) || stackHashMap.get(key).empty()) {
            return;
        }
        stackHashMap.get(key).clear();
    }


    public void clearStack() {
        stackHashMap.clear();
    }

    /**
     * clear all stack
     */
    public void destroy() {
        stackHashMap.clear();
    }

    /**
     * This method called from Activity onBackPressed (get second last fragment)
     *
     * @param key key for fragment stack
     * @return fragment if available or null
     */
    public Fragment onBackPressed(String key) {
        if (stackHashMap == null || !stackHashMap.containsKey(key) || stackHashMap.get(key).empty()) {
            return null;
        }
        Fragment fragment = stackHashMap.get(key).pop();
        if (fragment != null) {
            Log.e(TAG, "#onBackPressed: " + fragment.getClass().getSimpleName() + stackHashMap.get(key).empty());
        }
        if (!stackHashMap.get(key).empty()) {
            return stackHashMap.get(key).pop();
        }
        return null;
    }

    public Fragment popFragmentToTaggedFragment(FragmentActivity activity, String key, String tag) {

        for (Map.Entry<String, Stack<Fragment>> entry : stackHashMap.entrySet()) {
            Log.e(TAG, "popFragmentToTaggedFragment() entry = [" + entry.getKey() + " : " + entry.getValue().size() + "]");
        }

        if (stackHashMap == null || !stackHashMap.containsKey(key) || stackHashMap.get(key).empty()) {
            return null;
        }

        // pop last
        int popCount = 0;
        int size = stackHashMap.get(key).size() - 1;
        for (int pos = size; pos >= 0; pos--) {
            Fragment f = stackHashMap.get(key).get(pos);
            Log.e(TAG, "popFragmentToTaggedFragment() called with: f = [" + f.getClass().getSimpleName() + " = " + pos + "]");
            if (f.getClass().getSimpleName().equals(tag)) {
                popCount = size - pos;
                break;
            }
        }
        Log.e(TAG, "popFragmentToTaggedFragment() called with: popCount = [" + popCount + "]");
        Fragment fragment = null;
        for (int index = 0; index < popCount + 1; index++) {
            fragment = stackHashMap.get(key).pop();
        }
        return fragment;
    }
}
