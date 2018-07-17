package com.example.viewpager


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.bumptech.glide.Glide


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class MovieFragment : Fragment() {
    @BindView(R.id.tv_title)
    lateinit var tvTitle: TextView
    @BindView(R.id.tv_rating)
    lateinit var tvRating: TextView
    @BindView(R.id.tv_overview)
    lateinit var tvOverview: TextView
    @BindView(R.id.iv_movie)
    lateinit var ivmThumbnail: ImageView
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_movie, container, false)
        ButterKnife.bind(this,view)

        //Bind data
        val bundle = arguments
        tvTitle.text = bundle!!.getString(Const.KEY_TITLE)
        tvRating.text = bundle!!.getInt(Const.KEY_RATING).toString()
        tvOverview.text = bundle!!.getString(Const.KEY_OVERVIEW)
        val idImage = Const.identifieImage(activity!!,bundle.getString(Const.KEY_POSTER_URI))
        Glide.with(activity!!).load(idImage).into(ivmThumbnail)
        return view
    }

    companion object {
        fun newInstance(movie: MovieFavorite): MovieFragment{
            val bundle = Bundle()
            bundle.putString(Const.KEY_TITLE,movie.title)
            bundle.putInt(Const.KEY_RATING,movie.rating)
            bundle.putString(Const.KEY_POSTER_URI,movie.postUri)
            bundle.putString(Const.KEY_OVERVIEW,movie.overview)

            var fragment = MovieFragment()
            fragment.arguments = bundle

            return fragment
        }
    }
}
