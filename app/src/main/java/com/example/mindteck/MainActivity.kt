package com.example.mindteck

import android.graphics.BitmapFactory
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.InsetDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.core.view.ViewCompat
import androidx.core.widget.doOnTextChanged
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.example.mindteck.databinding.ActivityMainBinding
import com.example.mindteck.model.ListData
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    companion object {
        const val MAIN_TAG = "main_fragment"

        @BindingAdapter("app:appSetImageIcon")
        @JvmStatic
        fun appSetImageIcon(view: ImageView, resource: Int) {
            view.setImageResource(resource)
        }
    }

    lateinit var binding: ActivityMainBinding
    lateinit var listAdapter: ListAdapter
    lateinit var mainAdapter: MainAdapter

    //Array of fruits names
    var fruitsNames = arrayOf(
        "Apple",
        "Strawberry",
        "Pomegranates",
        "Oranges",
        "Watermelon",
        "Bananas",
        "Kiwi",
        "Grapes"
    )

    //Array of fruits images
    var fruitsImage = intArrayOf(
        R.drawable.apple,
        R.drawable.strawberry,
        R.drawable.pomegranates,
        R.drawable.oranges,
        R.drawable.watermelon,
        R.drawable.banana,
        R.drawable.kiwi,
        R.drawable.grapes
    )

    //Array of Heroes names
    var heroesNames = arrayOf(
        "Tom Cruise",
        "Tom Hardy",
        "Johnny Depp",
        "Robert De Niro",
        "Leonardo DiCaprio",
        "Will Smith",
        "Russell Crowe",
        "Christian Bale",
        "Morgan Freeman",
        "Hugh Jackman",
        "Keanu Reeves",
        "Tom Hanks",
        "Robert Downey Jr."
    )
    var heroesImage = intArrayOf(
        R.drawable.tom_cruise,
        R.drawable.tom_hardy,
        R.drawable.johnny,
        R.drawable.robert_de,
        R.drawable.leonardo,
        R.drawable.will,
        R.drawable.russell,
        R.drawable.christian,
        R.drawable.morgan,
        R.drawable.hugh,
        R.drawable.keanu,
        R.drawable.tom,
        R.drawable.robert
    )

    //Array of Banks names
    var banksNames = arrayOf(
        "ICICI",
        "Bank of America",
        "HDFC BANK",
        "Union Bank",
        "Wells Fargo",
        "State Bank of India",
        "citibank",
        "other"
    )
    var banksImage = intArrayOf(
        R.drawable.icici,
        R.drawable.boa,
        R.drawable.hdfc,
        R.drawable.union,
        R.drawable.wells,
        R.drawable.sboi,
        R.drawable.citibank,
        R.drawable.online_banking
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.activity_main, null, false)
        setContentView(binding.root)
        listAdapter = ListAdapter()

        binding.viewPager.offscreenPageLimit = 3
        mainAdapter = MainAdapter(this)
        binding.viewPager.adapter = mainAdapter
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { _, _ ->
        }.attach()

        val pageMargin = resources.getDimensionPixelOffset(R.dimen.pageMargin).toFloat()
        val pageOffset = resources.getDimensionPixelOffset(R.dimen.offset).toFloat()

        binding.viewPager.setPageTransformer { page: View, position: Float ->
            val myOffset = position * -(2 * pageOffset + pageMargin)
            if (binding.viewPager.orientation == ViewPager2.ORIENTATION_HORIZONTAL) {
                if (ViewCompat.getLayoutDirection(binding.viewPager) == ViewCompat.LAYOUT_DIRECTION_RTL) {
                    page.translationX = -myOffset
                } else {
                    page.translationX = myOffset
                }
            } else {
                page.translationY = myOffset
            }
        }

        val layoutManager1 = LinearLayoutManager(this).apply {
            orientation = LinearLayoutManager.VERTICAL
        }
        binding.rvRecyclerView.adapter = listAdapter
        with(binding.rvRecyclerView) {
            val ATTRS = intArrayOf(android.R.attr.listDivider)

            val a = context.obtainStyledAttributes(ATTRS)
            val divider = ColorDrawable(0xE6E6EB)
            val inset = resources.getDimensionPixelSize(R.dimen.divider_margin)
            val insetDivider = InsetDrawable(divider, inset, 0, 0, 0)
            a.recycle()

            val itemDecoration = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
            itemDecoration.setDrawable(insetDivider)
            addItemDecoration(
                itemDecoration
            )
            layoutManager = layoutManager1
        }
        val listDataList: ArrayList<ListData> = ArrayList()
        for (i in heroesNames.indices) {
            listDataList.add(
                ListData(
                    BitmapFactory.decodeResource(
                        resources,
                        heroesImage[i]
                    ), heroesNames[i]
                )
            )
        }
        listAdapter.setData(listDataList)

        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                listAdapter.clear()
                super.onPageSelected(position)
                when (position) {
                    0 -> {
                        //initialize heroes list
                        val listDataList: ArrayList<ListData> = ArrayList()
                        for (i in heroesNames.indices) {
                            listDataList.add(
                                ListData(
                                    BitmapFactory.decodeResource(
                                        resources,
                                        heroesImage[i]
                                    ), heroesNames[i]
                                )
                            )
                        }
                        listAdapter.setData(listDataList)

                    }
                    1 -> {
                        //initialize banks list
                        val bankList: ArrayList<ListData> = ArrayList()
                        for (i in banksNames.indices) {
                            bankList.add(
                                ListData(
                                    BitmapFactory.decodeResource(
                                        resources,
                                        banksImage[i]
                                    ), banksNames[i]
                                )
                            )
                            listAdapter.setData(bankList)

                        }
                    }
                    else -> {
                        //initialize fruits list
                        val fruitsList: ArrayList<ListData> = ArrayList()
                        for (i in fruitsNames.indices) {
                            fruitsList.add(
                                ListData(
                                    BitmapFactory.decodeResource(
                                        resources,
                                        fruitsImage[i]
                                    ), fruitsNames[i]
                                )
                            )
                            listAdapter.setData(fruitsList)

                        }

                    }
                }
            }
        })
        binding.searchBadge.doOnTextChanged { text, start, before, count ->
            listAdapter.search(text.toString())
        }
        binding.executePendingBindings()
    }

}