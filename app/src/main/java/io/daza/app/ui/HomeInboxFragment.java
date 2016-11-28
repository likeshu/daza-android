/**
 * Copyright (C) 2015 JianyingLi <lijy91@foxmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.daza.app.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import io.daza.app.R;
import io.daza.app.model.Notification;
import io.daza.app.model.Result;
import io.daza.app.ui.base.BaseFragment;
import io.daza.app.ui.base.BaseListFragment;
import io.daza.app.ui.vh.NotificationViewHolder;

public class HomeInboxFragment extends BaseListFragment<NotificationViewHolder, Notification, Result<ArrayList<Notification>>>{

    public HomeInboxFragment() {
        // Required empty public constructor
    }

    public static HomeInboxFragment newInstance() {
        HomeInboxFragment fragment = new HomeInboxFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_inbox, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        super.initLoader();
    }

    @Override
    public NotificationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_home_inbox_list_item, parent, false);
        return new NotificationViewHolder(itemView);
    }

    @Override
    public Result<ArrayList<Notification>> onLoadInBackground() throws Exception {
        Result<ArrayList<Notification>> result = new Result<>();

        ArrayList<Notification> data = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            data.add(new Notification());
        }
        result.setData(data);

        return result;
    }

    @Override
    public void onLoadComplete(Result<ArrayList<Notification>> data) {
        getItemsSource().addAll(data.getData());
        getAdapter().notifyDataSetChanged();
        super.onRefreshComplete();
    }
}
