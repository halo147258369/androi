package luanvan.com.jobsinhviennc;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class hstdAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Hstd> hstdList;


    public hstdAdapter(Context context, int layout, List<Hstd> hstdList) {
        this.context = context;
        this.layout = layout;
        this.hstdList = hstdList;

    }

    @Override
    public int getCount() {

        return hstdList.size();
    }

    @Override
    public Object getItem(int position) {

        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class ViewHolder {
        //TextView txtTieude, txtNhatuyendung, txtDiadiem;(ban đầu)
        TextView txtTieude, txtDiemDi, txtDiemDen;
        Button btnUngtuyen;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);
            holder.txtTieude = (TextView) convertView.findViewById(R.id.textviewTieudeCustom);
            holder.txtDiemDi = (TextView) convertView.findViewById(R.id.textviewDiemDiCustom);
            holder.txtDiemDen = (TextView) convertView.findViewById(R.id.textviewDiadiemCustom);
            holder.btnUngtuyen = (Button) convertView.findViewById(R.id.buttonUngtuyen);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        final Hstd hstd = hstdList.get(position);

        holder.txtTieude.setText(hstd.getTitle());
        holder.txtDiemDi.setText(hstd.getNamefrom());
        holder.txtDiemDen.setText(hstd.getNameto());
        holder.btnUngtuyen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  put(activity_mota.class,String.valueOf(hstd.getId()),hstd.getNtd(),hstd.getDchi()); ban đầu
                put(activity_mota.class, String.valueOf(hstd.getId()), hstd.getNamefrom(), hstd.getNameto());
            }
        });
        return convertView;
    }

    //ban dầu
//   private void put(Class cl,String id, String ntd, String dchi){
//        Intent intent = new Intent(context,cl);
//        intent.putExtra("id",id);
//        intent.putExtra("ntd",ntd);
//        intent.putExtra("dchi",dchi);
//        context.startActivity(intent);
//    }
//fix
    private void put(Class cl, String id, String namefrom, String nameto) {
        Intent intent = new Intent(context, cl);
        intent.putExtra("id", id);
        intent.putExtra("namefrom", namefrom);
        intent.putExtra("nameto", nameto);
        context.startActivity(intent);
//    }

    }
}