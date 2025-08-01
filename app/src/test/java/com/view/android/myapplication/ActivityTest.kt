package com.view.android.myapplication

import com.view.android.myapplication.main_page.fragment.MainFragment
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import junit.framework.TestCase.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@Config(sdk = [34]) // Robolectric max supported SDK
@RunWith(RobolectricTestRunner::class)
class ActivityTest {
    @Test
    fun runActivity() {
        val activity = Robolectric.buildActivity(MainActivity::class.java).setup().get()
        activity.loadFragment(MainFragment::class)

        val fragmentManager = activity.supportFragmentManager
        val fragment = fragmentManager.findFragmentByTag(MainFragment::class.java.simpleName)

        assertNotNull(fragment)
        assertTrue(fragment is MainFragment)
        assertEquals(1, fragmentManager.backStackEntryCount)
    }
}