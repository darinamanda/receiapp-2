package id.ac.ui.cs.mobileprogramming.darinamanda.receiapp3.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import id.ac.ui.cs.mobileprogramming.darinamanda.receiapp3.R
import kotlinx.android.synthetic.main.activity_homepage.*
import androidx.lifecycle.ViewModelProviders
import id.ac.ui.cs.mobileprogramming.darinamanda.receiapp3.viewmodel.RecipeViewModel


class MainActivity : AppCompatActivity(){

    init {
        System.loadLibrary("receiapp")
    }

    /**
     * Get random number
     */
    external fun randNumber(): Int
    private lateinit var viewModel: RecipeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)

        viewModel = ViewModelProviders.of(this).get(RecipeViewModel::class.java)

        val number = randNumber()
        viewModel.detailRecipe(number).observe(this, Observer { recipe ->
            recipe?.let {
                textview_recommended.text = recipe.name
            }
        })
    }


}
