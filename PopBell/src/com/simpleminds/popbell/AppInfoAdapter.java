package com.simpleminds.popbell;
import java.util.List;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
 
public class AppInfoAdapter extends BaseAdapter {
    private Context mContext;
    private List mListAppInfo;
    private PackageManager mPackManager;
 
    public AppInfoAdapter(Context c, List list, PackageManager pm) {
        mContext = c;
        mListAppInfo = list;
        mPackManager = pm;
    }
 
    @Override
    public int getCount() {
        return mListAppInfo.size();
    }
 
    @Override
    public Object getItem(int position) {
        return mListAppInfo.get(position);
    }
 
    @Override
    public long getItemId(int position) {
        return position;
    }
 
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // get the selected entry
        ApplicationInfo entry = (ApplicationInfo) mListAppInfo.get(position);
 
        // reference to convertView
        View v = convertView;
 
        // inflate new layout if null
        if(v == null) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            v = inflater.inflate(R.layout.listlayout_addapp, null);
        }
 
        // load controls from layout resources
 
        // load controls from layout resources
        ImageView ivAppIcon = (ImageView)v.findViewById(R.id.icon);
        TextView tvAppName = (TextView)v.findViewById(R.id.appname);
        TextView tvPkgName = (TextView)v.findViewById(R.id.pkgname);
 
        // set data to display
        ivAppIcon.setImageDrawable(entry.loadIcon(mPackManager));
        tvAppName.setText(entry.loadLabel(mPackManager));
        tvPkgName.setText(entry.packageName);
 
        // return view
        return v;
    }
}