package com.codepath.apps.restclienttemplate

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.codepath.apps.restclienttemplate.models.Tweet

class TweetsAdapter(private val tweets:ArrayList<Tweet>) : RecyclerView.Adapter<TweetsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TweetsAdapter.ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)

        //inflate item layout
        val view = inflater.inflate(R.layout.item_tweet, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: TweetsAdapter.ViewHolder, position: Int) {
        // get the data based on position
        val tweet: Tweet = tweets[position]
        //set item views based on view and data model
        holder.tvUsername.text = tweet.user?.name
        holder.tvTweetBody.text = tweet.body
        Glide.with(holder.itemView)
            .load(tweet.user?.publicImageUrl)
            .into(holder.ivProfileImage)
    }

    override fun getItemCount(): Int {
        return tweets.size
    }

    fun clear() {
        tweets.clear()
        notifyDataSetChanged()
    }

    fun addAll(tweetList: List<Tweet>) {
        tweets.addAll(tweetList)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView) {
        val ivProfileImage: ImageView = itemView.findViewById<ImageView>(R.id.ivProfileImage)
        val tvUsername: TextView = itemView.findViewById<TextView>(R.id.tvUsername)
        val tvTweetBody: TextView = itemView.findViewById<TextView>(R.id.tvTweetBody)
    }

}