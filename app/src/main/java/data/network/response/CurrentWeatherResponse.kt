package data.network.response

import com.google.gson.annotations.SerializedName
import data.db.entity.CurrentWeatherEntry
import data.db.entity.WeatherLocation


data class CurrentWeatherResponse(
    val location: WeatherLocation,
    @SerializedName("current")
    val currentWeatherEntry: CurrentWeatherEntry
)