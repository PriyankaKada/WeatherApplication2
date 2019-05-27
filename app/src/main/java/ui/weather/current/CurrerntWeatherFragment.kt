package ui.weather.current

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.weatherapplication.R
import com.resocoder.forecastmvvm.data.network.ConnectivityInterceptor
import com.resocoder.forecastmvvm.data.network.ConnectivityInterceptorImpl
import com.resocoder.forecastmvvm.data.network.WeatherNetworkDataSourceImpl
import data.Apicsoe
import kotlinx.android.synthetic.main.current_weather_fragment.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*


class CurrerntWeatherFragment : Fragment() {

    companion object {
        fun newInstance() = CurrerntWeatherFragment()
    }

    private lateinit var viewModel: CurrerntWeatherViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.current_weather_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val apiscso = Apicsoe(ConnectivityInterceptorImpl(this.context!!))
        val weatherNetworkDataSource = WeatherNetworkDataSourceImpl(apiscso)
        weatherNetworkDataSource.downloadedCurrentWeather.observe(this, androidx.lifecycle.Observer {
            txt.text = it.toString()
        })


        GlobalScope.launch(Dispatchers.Main) {

            weatherNetworkDataSource.fetchCurrentWeather("Mumbai", "en")

        }


    }

}
