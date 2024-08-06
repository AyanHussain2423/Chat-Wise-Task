package Models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Dimensions(
    @SerializedName("width") val width: Double,
    @SerializedName("height") val height: Double,
    @SerializedName("depth") val depth: Double
): Serializable