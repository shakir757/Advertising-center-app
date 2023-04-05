package com.advertising.center.app.go.ui.home

import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.advertising.center.app.go.R
import com.advertising.center.app.go.classes.Banner
import com.advertising.center.app.go.classes.RecyclerViewCreditAdapter
import com.advertising.center.app.go.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private var myBanners: MutableList<Banner> = mutableListOf(
        Banner(
            R.drawable.ic_bigprinter,
            R.color.bg_printer,
            R.string.text_printer
        ),
        Banner(
            R.drawable.ic_letter,
            R.color.bg_letter,
            R.string.text_letter
        ),
        Banner(
            R.drawable.ic_business_card,
            R.color.bg_business_card,
            R.string.text_business_card
        ),
        Banner(
            R.drawable.ic_open,
            R.color.bg_open,
            R.string.text_open
        ),
        Banner(
            R.drawable.ic_cup,
            R.color.bg_cup,
            R.string.text_cup
        ),
        Banner(
            R.drawable.ic_tshirt,
            R.color.bg_tshirt,
            R.string.text_tshirt
        ),
        Banner(
            R.drawable.ic_macbook,
            R.color.bg_macbook,
            R.string.text_macbook
        )
    )

    private val imageList = listOf(
        R.drawable.credit_1,
        R.drawable.credit_2,
        R.drawable.credit_3,
        R.drawable.credit_4,
        R.drawable.credit_5,
        R.drawable.credit_6,
        R.drawable.credit_7,
        R.drawable.credit_8
    )

    private var position = -1
    private val timer = object : CountDownTimer(999000000, 1500){
        override fun onFinish() {

        }

        override fun onTick(p0: Long) {
            position++
            if (position > 6){
                position = 0
            }
            binding.imageViewCategories.setImageResource(
                myBanners[position].imageResource)
            binding.constraintLayoutCategories.setBackgroundResource(
                myBanners[position].colorBg)
            binding.textViewCategories.setText(myBanners[position].myText)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        timer.start()
        val recyclerView: RecyclerView = view.findViewById(R.id.recycler_view_credits)
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = RecyclerViewCreditAdapter(imageList)
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                recyclerView.context,
                DividerItemDecoration.HORIZONTAL
            )
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()

        timer.cancel()
    }
}