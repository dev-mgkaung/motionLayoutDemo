package mk.learner.motionlayoutdemo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import mk.learner.motionlayoutdemo.databinding.ActivityViewPagerIntegrationBinding

class ViewPagerIntegration : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityViewPagerIntegrationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // set up view pager to have three tabs
        val adapter = ViewPagerAdapter(supportFragmentManager)

        adapter.addPageFragment(Page1(), "List")
        adapter.addPageFragment(Page2(), "Item")
        adapter.addPageFragment(Page3(), "Launch")

        binding.pager.adapter = adapter
        binding.tabs.setupWithViewPager(binding.pager)

        // use a page change listener to transfer swipe progress to MotionLayout
        binding.pager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                // calculate the swipe progress to a percent between 0f and 1f, where 0f is the
                // first tab and 1f is the last tab
                val progress = (position + positionOffset) / (adapter.count - 1)
                // ask MotionLayout to snap to the current progress
                binding.motionLayout.progress = progress
            }

            override fun onPageSelected(position: Int) {
                // ignore
            }

            override fun onPageScrollStateChanged(state: Int) {
                // ignore
            }

        })
    }
}

/**
 * Adapter needed for ViewPager
 */
class ViewPagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(
    fragmentManager,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
) {

    private val fragmentList = ArrayList<Fragment>()
    private val fragmentTitleList = ArrayList<String>()

    override fun getItem(position: Int): Fragment {
        return fragmentList[position]
    }

    override fun getCount(): Int {
        return fragmentList.size
    }

    fun addPageFragment(fragment: Fragment, title: String) {
        fragmentList.add(fragment)
        fragmentTitleList.add(title)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return fragmentTitleList[position]
    }
}

/**
 * Fragments for ViewPager
 */
class Page1 : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.page_1, container, false)
    }
}

/**
 * Fragments for ViewPager
 */
class Page2 : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.page_2, container, false)
    }
}

/**
 * Fragments for ViewPager
 */
class Page3 : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.page_3, container, false)
    }
}