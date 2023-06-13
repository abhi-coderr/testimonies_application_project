package com.yogeshwar.testimoniesapp.core.validator

import android.content.Context
import com.yogeshwar.testimoniesapp.core.validator.Validator.isEmailValid
import com.yogeshwar.testimoniesapp.core.validator.Validator.validationForNotEmpty


/**
 * Description: This object is used for separating the App Level Validation logic from the Custom Edit Text View Class.
 *
 * @author Ankit Mishra
 * @since 21/01/22
 */
object MyValidations {

    /**
     * This enum class represents the edit text type.
     * @param value Provide the value it is in the Custom Edit Text View.
     */
    enum class FieldType(val value: Int) {
        EMAIL(1),
        PASSWORD(2),
        CONFIRM_PASSWORD(3),
        PHONE_NUMBER(4),
        FIRST_NAME(5),
        LAST_NAME(6);
    }

    /**
     * Description: This method is used for setting up the text validations for all the edit texts.
     *
     * @author Ankit Mishra
     * @since 21/01/22
     */
    fun setAllEditTextValidations(context: Context) {
        Validator.setValidation(
            FieldType.EMAIL.value, listOf(
                validationForNotEmpty("Please enter your email address"),
                Validator.SingleValidation(
                    validationFunc = ::isEmailValid,
                    errorMessage = "Please enter valid email address"
                )
            )
        ).setValidation(
            FieldType.PASSWORD.value,
            listOf(
                validationForNotEmpty("Please enter your password.")
            )
        ).setValidation(
            FieldType.CONFIRM_PASSWORD.value,
            listOf(
                validationForNotEmpty("Please enter confirm password.")
            ),
            listOf(
                Validator.ComparisonValidation(
                    validationFunc = { text, otherText -> text == otherText },
                    errorMessage = "Please enter confirm password same as password."
                )
            )
        )

    }
    fun showMessageIfErrorElseReturnTrue(
        listOfErrors:List<String>,
        onError:(String)->Unit
    ): Boolean {
        val errorMessage = listOfErrors.find { it.isNotBlank() }.orEmpty()
        return if (errorMessage.isNotBlank()) {
            onError(errorMessage)
            false
        } else {
            true
        }
    }
}