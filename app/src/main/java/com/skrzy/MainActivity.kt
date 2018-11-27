package com.skrzy

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {


    private val LOG_TAG = MainActivity::class.java.simpleName
    private var mMessageName : EditText? = null
    private var mMessageAdress : EditText? = null
    private var mMessagePhone : EditText? = null
    private var mMessageEmail : EditText? = null
    private var mMessageRemarks : EditText? = null
    private var mMessagePayment : Spinner? = null
    private var mMessageDelivery : String? = null

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val spinnerLabel = parent?.getItemAtPosition(position).toString()
        displayToast(spinnerLabel)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val spinner : Spinner = findViewById(R.id.spinner)
        if(spinner != null) {
            spinner.onItemSelectedListener
        }
        val adapter : ArrayAdapter<CharSequence> = ArrayAdapter.createFromResource(this, R.array.label_arrays, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        if(spinner != null) {
            spinner.setAdapter(adapter)
        }
        mMessageName = findViewById(R.id.name_text)
        mMessageAdress = findViewById(R.id.adress_text)
        mMessagePhone = findViewById(R.id.phone_text)
        mMessageEmail = findViewById(R.id.email_text)
        mMessageRemarks = findViewById(R.id.remarks_text)
        mMessagePayment = findViewById(R.id.spinner)
        mMessageDelivery = getString(R.string.courier_delivery)
    }

    fun launchSecondActivity(view : View) {
        Log.d(LOG_TAG, "Button clicked!")
        val intent = Intent(this, SecondActivity::class.java)
        val messageName : String = mMessageName?.getText().toString()
        val messageAdress : String = mMessageAdress?.getText().toString()
        val messagePhone : String = mMessagePhone?.getText().toString()
        val messageEmail : String = mMessageEmail?.getText().toString()
        val messageRemarks : String = mMessageRemarks?.getText().toString()
        val messagePayment : String = mMessagePayment?.selectedItem.toString()
        val messageDelivery : String = mMessageDelivery.toString()
        intent.putExtra("Name",messageName)
        intent.putExtra("Adress", messageAdress)
        intent.putExtra("Phone",messagePhone)
        intent.putExtra("Email", messageEmail)
        intent.putExtra("Remarks",messageRemarks)
        intent.putExtra("Payment", messagePayment)
        intent.putExtra("Delivery",messageDelivery)
        startActivity(intent)
    }

    fun onRadioButtonClicked(view : View) {
        val checked = (view as RadioButton).isChecked

        when(view.getId()) {
            R.id.courier -> if(checked) {
                mMessageDelivery = getString(R.string.courier_delivery)
                displayToast(getString(R.string.courier_delivery))
            }
            R.id.post -> if(checked) {
                mMessageDelivery = getString(R.string.post_delivery)
                displayToast(getString(R.string.post_delivery))
            }
            R.id.pickup -> if(checked) {
                mMessageDelivery = getString(R.string.pick_up)
                displayToast(getString(R.string.pick_up))
            }
        }
    }

    fun displayToast(message : String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }
}
