package com.kubeiwu.commontool.fragment;

import com.kubeiwu.commontool.R;
import com.kubeiwu.commontool.adapter.KFragmentPagerAdapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class BaseFragmentViewPager extends Fragment {
	protected ViewPager mPager;
	protected KFragmentPagerAdapter adapter;
	private View view;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.fragment_pager, container, false);
//		if()
		mPager = (ViewPager) view.findViewById(R.id.pager);
//		adapter = new KFragmentPagerAdapter(getChildFragmentManager(), data);
		return super.onCreateView(inflater, container, savedInstanceState);
	}

}
