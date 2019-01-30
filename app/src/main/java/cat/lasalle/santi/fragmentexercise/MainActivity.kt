package cat.lasalle.santi.fragmentexercise

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(), EmailFragment.OnButtonPressedListener {
    override fun onButtonPressed() {
        val f = ListFragment()
        supportFragmentManager.beginTransaction().
                replace(R.id.main_container, f).
                commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val f = EmailFragment()
        supportFragmentManager.beginTransaction().
            add(R.id.main_container, f).
            commit()
    }
}
