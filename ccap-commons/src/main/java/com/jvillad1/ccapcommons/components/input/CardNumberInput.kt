package com.jvillad1.ccapcommons.components.input

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.jvillad1.ccap.R
import com.jvillad1.ccap.databinding.CardNumberInputBinding

class CardNumberInput : ConstraintLayout {

    /**
     * The placeholder to draw
     */
    var placeholder: String? = null
        set(value) {
            field = value
            inputLayoutComponent.hint = value.orEmpty()
        }

    /**
     * The text to draw
     */
    var text: String?
        get() = textComponent.text.toString()
        set(value) {
            textComponent.setText(value)
        }


    private val binding by lazy {
        CardNumberInputBinding.inflate(LayoutInflater.from(context), this)
    }

    private var inputLayoutComponent: TextInputLayout = binding.inputLayout
    private var textComponent: TextInputEditText = binding.input

    constructor(context: Context) : super(context) {
        init(null, 0)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(attrs, 0)
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    ) {
        init(attrs, defStyle)
    }

    private fun init(attrs: AttributeSet?, defStyle: Int) {
        // Load attributes
        context.obtainStyledAttributes(
            attrs, R.styleable.CardNumberInput, defStyle, 0
        ).apply {
            placeholder = getString(R.styleable.CardNumberInput_placeholderText).orEmpty()

            recycle()
        }
    }
}
