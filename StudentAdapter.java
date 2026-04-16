package com.mybrand.newlab3_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class StudentAdapter extends BaseAdapter {

    private Context context;
    private List<Student> students;

    public StudentAdapter(Context context, List<Student> students) {
        this.context = context;
        this.students = students;
    }

    @Override
    public int getCount() {
        return students.size();
    }

    @Override
    public Object getItem(int position) {
        return students.get(position);
    }

    @Override
    public long getItemId(int position) {
        return students.get(position).getId();
    }

    static class ViewHolder {
        TextView nameText;
        TextView departmentText;
        Button likeButton;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        Student student = students.get(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(context)
                    .inflate(R.layout.student_item, parent, false);

            holder = new ViewHolder();
            holder.nameText = convertView.findViewById(R.id.textname);
            holder.departmentText = convertView.findViewById(R.id.textdepartment);
            holder.likeButton = convertView.findViewById(R.id.likeButton);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.nameText.setText(student.getName());
        holder.departmentText.setText(student.getDepartment());
        holder.likeButton.setText("Like (" + student.getLikes() + ")");

        holder.likeButton.setOnClickListener(v -> {
            student.setLikes(student.getLikes() + 1);
            notifyDataSetChanged();
        });

        return convertView;
    }
}
