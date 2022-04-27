package com.kdev.navigation2.activitys

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.kdev.navigation2.R
import com.kdev.navigation2.databinding.ActivityMainBinding
import com.kdev.navigation2.fragments.FavFragment
import com.kdev.navigation2.fragments.HomeFragment
import com.kdev.navigation2.fragments.SearchFragment
import com.kdev.navigation2.fragments.TimelineFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private var prevIndexNav = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setEventClicks()
        //default
        processState(1)
    }

    private fun setEventClicks() {
        binding.nav.btnHome.setOnClickListener { processState(1) }
        binding.nav.btnSearch.setOnClickListener { processState(2) }
        binding.nav.btnFav.setOnClickListener { processState(3) }
        binding.nav.btnTimeline.setOnClickListener { processState(4) }
    }

    fun processState(index: Int) {
        if (index != prevIndexNav) {
            setUIDisableButton(prevIndexNav)
            setUIEnableButton(index)
            prevIndexNav = index
        }
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    fun setUIEnableButton(index: Int) {
        val animScaleUp = AnimationUtils.loadAnimation(this, R.anim.anim_scale_up)
        val animRotate = AnimationUtils.loadAnimation(this, R.anim.anim_icon)

        when (index) {
            1 -> {
                binding.nav.btnHome.startAnimation(animScaleUp)
                binding.nav.imHome.setImageResource(R.drawable.ic_home)
                binding.nav.btnHome.background.setTint(
                    ContextCompat.getColor(
                        this,
                        R.color.bg_btn_home
                    )
                )
                binding.nav.imHome.startAnimation(animRotate)

                replaceFragment(HomeFragment())
            }
            2 -> {
                binding.nav.btnSearch.startAnimation(animScaleUp)
                binding.nav.imSearch.setImageResource(R.drawable.ic_search)
                binding.nav.btnSearch.background.setTint(
                    ContextCompat.getColor(
                        this,
                        R.color.bg_btn_search
                    )
                )
                binding.nav.imSearch.startAnimation(animRotate)

                replaceFragment(SearchFragment())
            }
            3 -> {
                binding.nav.btnFav.startAnimation(animScaleUp)
                binding.nav.imFav.setImageResource(R.drawable.ic_favorite)
                binding.nav.btnFav.background.setTint(
                    ContextCompat.getColor(
                        this,
                        R.color.bg_btn_fav
                    )
                )
                binding.nav.imFav.startAnimation(animRotate)
                replaceFragment(FavFragment())

            }
            4 -> {
                binding.nav.btnTimeline.startAnimation(animScaleUp)
                binding.nav.imTimeline.setImageResource(R.drawable.ic_date)
                binding.nav.btnTimeline.background.setTint(
                    ContextCompat.getColor(
                        this,
                        R.color.bg_btn_timeline
                    )
                )
                binding.nav.imTimeline.startAnimation(animRotate)
                replaceFragment(TimelineFragment())
            }
        }
    }

    fun setUIDisableButton(index: Int) {
        val animScaleUp = AnimationUtils.loadAnimation(this, R.anim.anim_scale_up)

        when (index) {
            1 -> {
                binding.nav.btnHome.startAnimation(animScaleUp)
                binding.nav.imHome.setImageResource(R.drawable.ic_home_gray)
                binding.nav.btnHome.background.setTint(ContextCompat.getColor(this, R.color.gray))
            }
            2 -> {
                binding.nav.btnSearch.startAnimation(animScaleUp)
                binding.nav.imSearch.setImageResource(R.drawable.ic_search_gray)
                binding.nav.btnSearch.background.setTint(ContextCompat.getColor(this, R.color.gray))
            }
            3 -> {
                binding.nav.btnFav.startAnimation(animScaleUp)
                binding.nav.imFav.setImageResource(R.drawable.ic_favorite_gray)
                binding.nav.btnFav.background.setTint(ContextCompat.getColor(this, R.color.gray))
            }
            4 -> {
                binding.nav.btnTimeline.startAnimation(animScaleUp)
                binding.nav.imTimeline.setImageResource(R.drawable.ic_date_gray)
                binding.nav.btnTimeline.background.setTint(
                    ContextCompat.getColor(
                        this,
                        R.color.gray
                    )
                )
            }
        }
    }

    fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container, fragment)
        fragmentTransaction.commit()
    }
}