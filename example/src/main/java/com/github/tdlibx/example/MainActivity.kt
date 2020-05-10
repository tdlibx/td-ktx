package com.github.tdlibx.example

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.input.input

class MainActivity : AppCompatActivity() {

    private val vm: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        vm.authState.observe(this, Observer { state ->
            Toast.makeText(
                this,
                state?.toString(),
                Toast.LENGTH_LONG
            )
            if (state != null && state !is AuthState.LoggedIn) {
                MaterialDialog(this).show {
                    input(hint = state.dialogHint) { _, text ->
                        when (state) {
                            AuthState.EnterPhone -> vm.sendPhone(text.toString())
                            AuthState.EnterCode -> vm.sendCode(text.toString())
                            is AuthState.EnterPassword -> vm.sendPassword(text.toString())
                        }
                    }
                    positiveButton(R.string.send)
                }
            }
        })

        vm.error.observe(this, Observer {
            MaterialDialog(this).show {
                title(text = "Error!")
                message(text = it)
            }
        })
    }
}