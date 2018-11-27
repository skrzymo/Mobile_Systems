package com.skrzy

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val intent = intent
        val messageName : String = intent.getStringExtra("Name")
        val messageAdress : String = intent.getStringExtra("Adress")
        val messagePhone : String = intent.getStringExtra("Phone")
        val messageEmail : String = intent.getStringExtra("Email")
        val messageRemarks : String = intent.getStringExtra("Remarks")
        val messagePayment : String = intent.getStringExtra("Payment")
        val messageDelivery : String = intent.getStringExtra("Delivery")
        val nameSummary : TextView = findViewById(R.id.name_message_summary)
        val adressSummary : TextView = findViewById(R.id.adress_message_summary)
        val phoneSummary : TextView = findViewById(R.id.phone_message_summary)
        val emailSummary : TextView = findViewById(R.id.email_message_summary)
        val remarksSummary : TextView = findViewById(R.id.remarks_message_summary)
        val paymentSummary : TextView = findViewById(R.id.payment_method_message_summary)
        val deliverySummary : TextView = findViewById(R.id.delivery_method_message_summary)

        nameSummary.setText(messageName)
        adressSummary.setText(messageAdress)
        phoneSummary.setText(messagePhone)
        emailSummary.setText(messageEmail)
        remarksSummary.setText(messageRemarks)
        paymentSummary.setText(messagePayment)
        deliverySummary.setText(messageDelivery)
    }

    fun launchSecondActivity(view : View) {
        val intent = Intent(this, ThirdActivity::class.java)
        startActivity(intent)
    }
}
