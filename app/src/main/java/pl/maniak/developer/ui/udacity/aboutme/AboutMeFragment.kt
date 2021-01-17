package pl.maniak.developer.ui.udacity.aboutme

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.android.aboutme.MyName
import pl.maniak.developer.R
import pl.maniak.developer.databinding.FragmentAboutMeBinding

class AboutMeFragment : Fragment() {

    // Binding object for MainActivity.
    // Name of the object is derived from the name of the activity or fragment.
    private lateinit var binding: FragmentAboutMeBinding

    // Instance of MyName data class.
    private val myName: MyName = MyName("Piotr Liszka")

    private lateinit var viewModel: AboutMeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Setting the content view using DataBindingUtil creates an instance of
        // FragmentAboutMeBinding from the inflated fragment and the supplied layout. This object
        // contains mappings between the fragment and layout,
        // and functionality to interact with them.
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_about_me, container, false)
        // Set the value of the myName variable that is declared and used in the layout file.
        binding.myName = myName

        // Click listener for the Done button.
        binding.doneButton.setOnClickListener {
            addNickname(it)
        }

        return binding.root
    }

    /**
     * Click handler for the Done button.
     * Demonstrates how data binding can be used to make code much more readable
     * by eliminating calls to findViewById and changing data in the binding object.
     */
    private fun addNickname(view: View) {
        binding.apply {
            // Set the text for nicknameText to the value in nicknameEdit.
            myName?.nickname = nicknameEdit.text.toString()
            // Invalidate all binding expressions and request a new rebind to refresh UI
            invalidateAll()
            // Change which views are visible.
            // Remove the EditText and the Button.
            // With GONE they are invisible and do not occupy space.
            nicknameEdit.visibility = View.GONE
            doneButton.visibility = View.GONE

            // Make the TexView with the nickname visible.
            nicknameText.visibility = View.VISIBLE

        }
        // Hide the keyboard.
        val imm =
            requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AboutMeViewModel::class.java)
    }
}