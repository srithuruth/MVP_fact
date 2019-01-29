package com.example.mvp_fact

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.example.mvp_fact.model.APIData
import com.example.mvp_fact.ui.home.APIAdapter
import com.example.mvp_fact.ui.home.App
import com.example.mvp_fact.ui.home.HomeContract
import com.example.mvp_fact.ui.home.HomePresenter
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HomeContract.View

private val apiAdapter = APIAdapter()

@Inject
lateinit var homePresenter: HomePresenter.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DaggerHomeComponent.builder()
            .appComponent((application as App).getComponent())
            .homeModule(HomeModule(this))
            .build()
            .inject(this)

        rvPasses.layoutManager = LinearLayoutManager(this)
        rvPasses.adapter = apiAdapter

        btnDisplay.setOnClickListner{
            homePresenter.getDetails(animalId.toString(), animalDesc.toString(), updatedAt.toString())
        }


    }

override fun showResults(results: List<APIData>) {
    apiAdapter.setData(results)
}

override fun showError(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}
}
