package com.example.notekeeper;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.notekeeper.databinding.FragmentFirstBinding;

import java.util.List;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Spinner spinnerCourse = binding.spinnerNoteCourse;
        List<CourseInfo> courseInfoList = DataManager.getInstance().getCourses();
        ArrayAdapter<CourseInfo> courseInfoArrayAdapter =
                new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, courseInfoList);
        courseInfoArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCourse.setAdapter(courseInfoArrayAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}