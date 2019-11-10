package com.example.healthrecord

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class MainDialogFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(context)
        builder.apply {
            setTitle("保存処理")
            setMessage("保存します")
            setPositiveButton("OK", DialogInterface.OnClickListener { dialog, which -> })
        }
        return builder.create()
    }
}