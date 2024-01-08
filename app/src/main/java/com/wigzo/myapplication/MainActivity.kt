package com.sample.samplewigzo

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.tasks.OnCanceledListener
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.messaging.FirebaseMessaging
import com.sample.samplewigzo.databinding.ActivityMainBinding
import com.wigzo.android.models.EventData
import com.wigzo.android.tasks.EventMapper
import com.wigzo.android.tasks.FCMMapper
import com.wigzo.android.tasks.UserProfileMapper

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(getLayoutInflater())
        setContentView(binding.root)

        //        FCM token
        FirebaseMessaging.getInstance().getToken()
            .addOnSuccessListener(OnSuccessListener<String> { token: String ->
                Log.i("FCM_TOKEN", token)
                sendRegistrationToServer(token)
            }).addOnCanceledListener(OnCanceledListener { Log.i("FCM_TOKEN", "Cancelled") })
            .addOnFailureListener(
                OnFailureListener { e: Exception -> Log.i("FCM_TOKEN", e.message!!) })


        binding.signInButton.setOnClickListener { view -> getWigzoUserProfile() }

        binding.searchButton.setOnClickListener { view ->
            sendWigzoSearchEvent(
                binding.searchEditText.text.toString()
            )
        }

    }

    private fun sendRegistrationToServer(token: String) {
        // TODO: Implement this method to send token to your app server.
        val fcmMapper = FCMMapper(token)
        fcmMapper.push()

//      FCMRegister fcmRegister = new FCMRegister(token);
//    fcmRegister.push();
    }

    private fun getWigzoUserProfile() {
        val userProfileMapper = UserProfileMapper(
            "Akash Kumar",
            "akt",
            "akash@yopmail.com",
            "shiprocket wigzo",
            "9876543210", "Male", "1995", null
        )
        userProfileMapper.push()
    }

    private fun sendWigzoSearchEvent(searchText: String) {
        val eventData = EventData()
        eventData.setEventName("search")
        eventData.setEventValue(searchText)
        val eventMapper = EventMapper()
        eventMapper.addEventData(eventData)
        eventMapper.push()
    }

    private fun sendWigzoProductEvent(searchText: String) {
        val eventData = EventData()
        eventData.setEventName("search")
        eventData.setEventValue(searchText)
        val eventMapper = EventMapper()
        eventMapper.addEventData(eventData)
        eventMapper.push()
    }

}