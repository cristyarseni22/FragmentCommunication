package com.example.fragmentcommunicationinterfaceex2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fragmentcommunicationinterfaceex2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), Communicator {
    private lateinit var binding: ActivityMainBinding
    private lateinit var receiverFragment: ReceiverFragment
    private lateinit var senderFragment: SenderFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    private fun initView() {
        receiverFragment = ReceiverFragment()
        senderFragment = SenderFragment()

        supportFragmentManager.beginTransaction().replace(R.id.receiver, receiverFragment).commit()
        supportFragmentManager.beginTransaction().replace(R.id.sender, senderFragment).commit()
    }

    override fun sendUrl(url: String) {
        receiverFragment.setUrl(url)
    }
}