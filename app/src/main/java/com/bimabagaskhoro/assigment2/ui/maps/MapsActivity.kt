package com.bimabagaskhoro.assigment2.ui.maps

import android.content.Intent
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bimabagaskhoro.assigment2.R
import com.bimabagaskhoro.assigment2.databinding.ActivityMapsBinding
import com.bimabagaskhoro.assigment2.ui.adapter.EventAdapter
import com.bimabagaskhoro.assigment2.ui.event.EventViewModel
import com.mapbox.android.core.permissions.PermissionsManager
import com.mapbox.mapboxsdk.Mapbox
import com.mapbox.mapboxsdk.geometry.LatLng
import com.mapbox.mapboxsdk.location.LocationComponent
import com.mapbox.mapboxsdk.maps.MapboxMap
import com.mapbox.mapboxsdk.maps.Style
import com.mapbox.mapboxsdk.plugins.annotation.SymbolManager
import com.mapbox.mapboxsdk.plugins.annotation.SymbolOptions
import kotlinx.android.synthetic.main.activity_maps.*

class MapsActivity : AppCompatActivity() {
    companion object {
        private const val ICON_ID = "ICON_ID"
    }

    private lateinit var binding: ActivityMapsBinding
    private lateinit var mapboxMap: MapboxMap
    private lateinit var symbolManager: SymbolManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Mapbox.getInstance(this@MapsActivity, getString(R.string.mapbox_access_token))
        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val eventAdapter = EventAdapter()
        val viewModel = ViewModelProvider(this,
            ViewModelProvider.NewInstanceFactory())[EventViewModel::class.java]
        val movie = viewModel.getMovie()
        eventAdapter.setData(movie)

        binding.apply {
            rvEvent.layoutManager = LinearLayoutManager(this@MapsActivity, LinearLayoutManager.HORIZONTAL,false)
            rvEvent.setHasFixedSize(true)
            rvEvent.adapter = eventAdapter
        }

        binding.mapView.onCreate(savedInstanceState)
        binding.mapView.getMapAsync { mapboxMap ->
            this.mapboxMap = mapboxMap
            mapboxMap.setStyle(Style.MAPBOX_STREETS) { style ->
                symbolManager = SymbolManager(mapView, mapboxMap, style)
                symbolManager.iconAllowOverlap = true

                style.addImage(
                    ICON_ID,
                    BitmapFactory.decodeResource(resources, R.drawable.mapbox_marker_icon_default)
                )
                addMarkerOnClick()
            }
        }
    }

    private fun addMarkerOnClick() {
        mapboxMap.addOnMapClickListener { point ->
            symbolManager.deleteAll()
            symbolManager.create(
                SymbolOptions()
                    .withLatLng(LatLng(point.latitude, point.longitude))
                    .withIconImage(ICON_ID)
                    .withDraggable(true)
            )
            true
        }
    }
}