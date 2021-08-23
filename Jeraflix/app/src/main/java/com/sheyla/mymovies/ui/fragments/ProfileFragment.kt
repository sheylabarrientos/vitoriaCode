package com.sheyla.mymovies.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.sheyla.mymovies.R
import com.sheyla.mymovies.domain.Movie
import com.sheyla.mymovies.onclick.MovieListener
import com.sheyla.mymovies.ui.model.MoviesViewModel
import com.sheyla.mymovies.ui.adpater.ProfilesAdapter

class ProfileFragment : Fragment(), MovieListener {

    private lateinit var profilesListRcv: RecyclerView
    private lateinit var listAdapter: ProfilesAdapter
    private lateinit var progressBar: ProgressBar
    private lateinit var profilesViewModel: MoviesViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_profiles, container, false)
    }

    override fun openMovieDetails(movieId: Int) {
        TODO("Not yet implemented")
    }

    override fun loadMoviesWithGenre(genreIds: List<Int>) {
        TODO("Not yet implemented")
    }

    override fun onWatchListClickedListener(movie: Movie, isChecked: Boolean) {
        TODO("Not yet implemented")
    }

    override fun onWatchedListClickedListener(movie: Movie, isChecked: Boolean) {
        TODO("Not yet implemented")
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        profilesListRcv = view.findViewById(R.id.recyclerViewProfiles)
//        progressBar = view.findViewById(R.id.loading)
//
//        profilesViewModel = ViewModelProvider(requireActivity()).get(MoviesViewModel::class.java)
//
//        listAdapter = ProfilesAdapter(context = view.context, listener = this)
//        profilesListRcv.adapter = listAdapter
//
//
//        profilesViewModel.getProfiles()
//        progressBar = view.findViewById(R.id.loading)
//
//        observeProfiles()
//        observeViewState()
//
//
////        rvProfiles.addOnScrollListener(object : RecyclerView.OnScrollListener() {
////            override fun onScrolled(@NonNull recyclerView: RecyclerView, dx: Int, dy: Int): Unit {
////                var layout =
////                    (rvProfiles.layoutManager as LinearLayoutManager).findViewByPosition((rvProfiles.layoutManager as LinearLayoutManager).findFirstVisibleItemPosition())
////
////                val indexOfToggleButton = 2
////                val indexOfId = 5
////
////                if (layout is ConstraintLayout) {
////                    if (layout.getChildAt(indexOfId) is MaterialTextView) {
////                        val movieIdString =
////                            (layout.getChildAt(indexOfId) as MaterialTextView).text.toString()
////                        val movieId = Integer.parseInt(movieIdString)
////
////                        (layout.getChildAt(indexOfToggleButton) as AppCompatToggleButton).isChecked =
////                            MoviesViewModel.movieIdIsFavorite(movieId) == true
////                    }
////                }
////            }
////        })
//    }
//
//    override fun onResume() {
//        super.onResume()
//        profilesViewModel.getProfileId()
//    }
//
//    private fun observeProfiles() {
//        profilesViewModel.viewStateProfile.observe(viewLifecycleOwner, { response ->
//            response?.let {
//                listAdapter.dataSet.clear()
//                listAdapter.dataSet.addAll(it)
//                listAdapter.notifyDataSetChanged()
//                progressBar.visibility = View.GONE
//            }
//        })
//    }
//
//
//    private fun observeViewState() {
//        profilesViewModel.viewStateLiveData.observe(viewLifecycleOwner, { result ->
//            if (result == ViewState.GeneralError) {
//                val intent = Intent(requireContext(), ProfileFragment::class.java)
//                startActivity(intent)
//            }
//        })
//    }
//
//
//
//    override fun openMovieDetails(movieId: Int) {
//        TODO("Not yet implemented")
//    }
//
//    override fun loadMoviesWithGenre(genreIds: List<Int>) {
//        TODO("Not yet implemented")
//    }
//
//    override fun onWatchListClickedListener(movie: Movie, isChecked: Boolean) {
//        TODO("Not yet implemented")
//    }
//
//    override fun onWatchedListClickedListener(movie: Movie, isChecked: Boolean) {
//        TODO("Not yet implemented")
//    }
//
//    override fun openProfiles(user: User, isChecked: Boolean) {
//        if (isChecked) {
//            user.username = "sheyla"
//            profilesViewModel.removeToProfiles(user)
//            //            MoviesViewModel.writeFavoriteMovie(movie)
//        } else {
//            user.username = null
//            profilesViewModel.removeToProfiles(user)
//            //            MoviesViewModel.deleteFavoriteMovie(movie)
//        }
//    }
}