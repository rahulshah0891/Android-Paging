package com.pagingdemo.binding

import android.view.View.GONE
import android.widget.ProgressBar
import androidx.databinding.BindingAdapter
import androidx.paging.PagedList
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.pagingdemo.model.UserEntity
import com.pagingdemo.ui.main.UserPagedListAdapter
import com.skydoves.whatif.whatIfNotNullOrEmpty

@BindingAdapter("adapter")
fun bindAdapter(view: RecyclerView, pagedAdapter: PagedListAdapter<*, *>) {
    view.adapter = pagedAdapter
}

@BindingAdapter("adapterUserList")
fun bindPagedAdapterUserList(view: RecyclerView, users: PagedList<UserEntity>) {
    users.whatIfNotNullOrEmpty(
        whatIf = {
            (view.adapter as UserPagedListAdapter).submitList(users)
        },
        whatIfNot = {
            view.visibility = GONE
        }
    )
}
@BindingAdapter("android:visibility")
fun setProgressBarVisibility(view: ProgressBar, users: PagedList<UserEntity>){

}
