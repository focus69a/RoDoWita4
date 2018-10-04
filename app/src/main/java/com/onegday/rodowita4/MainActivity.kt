package com.onegday.rodowita4


import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.support.design.widget.TabLayout


class MainActivity : AppCompatActivity() {


    lateinit var tabLayout: TabLayout
    lateinit var viewPager: ViewPager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager = findViewById(R.id.viewpagerID) as ViewPager


        //setupViewPager(viewPager)

        var adapter: ViewPagerAdapter = ViewPagerAdapter(supportFragmentManager)

        adapter.addFragment(JaUpowaznilemActivity(), "JA UPOWAŻNIŁEM")
        adapter.addFragment(JestemUpowaznionyActivity(), "MNIE UPOWAŻNIONO")
        adapter.addFragment(OProgramieActivity(), "O PROGRAMIE")

        viewPager.adapter = adapter

        tabLayout = findViewById(R.id.tabLayoutID) as TabLayout

        tabLayout.setupWithViewPager(viewPager)

    }

}

class ViewPagerAdapter : FragmentPagerAdapter {

    private val mFragmentList : MutableList<Fragment> = mutableListOf()
    private val mFragmentTitleList : MutableList<String> = mutableListOf()

    constructor(manager: FragmentManager) : super(manager)

    fun addFragment (fragment: Fragment, title: String) {
        mFragmentList.add(fragment)
        mFragmentTitleList.add(title)
    }

    override fun getItem(position: Int): Fragment {
        return mFragmentList.get(position)
    }

    override fun getCount(): Int {
        return mFragmentList.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mFragmentTitleList.get(position)
    }



}