package com.stripe.android.ui.core.elements

import androidx.annotation.RestrictTo
import androidx.annotation.StringRes
import kotlinx.serialization.Serializable

/**
 * Mandate text element spec.
 */
@RestrictTo(RestrictTo.Scope.LIBRARY_GROUP)
@Serializable
data class MandateTextSpec(
    override val apiPath: IdentifierSpec = DEFAULT_API_PATH,
    @StringRes
    val stringResId: Int,
) : FormItemSpec() {
    fun transform(merchantName: String): FormElement =
    // It could be argued that the static text should have a controller, but
        // since it doesn't provide a form field we leave it out for now
        MandateTextElement(
            this.apiPath,
            this.stringResId,
            merchantName
        )

    companion object {
        val DEFAULT_API_PATH = IdentifierSpec.Generic("mandate")
    }
}
