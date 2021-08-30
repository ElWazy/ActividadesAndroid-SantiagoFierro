package com.example.shop_santiagofierro.usecases;

import android.widget.ProgressBar;

import java.util.TimerTask;

public class LoadMyProgressBar extends TimerTask {
    private final int MAX_LIMIT = 100;
    private final int MIN_LIMIT = 0;

    private int progress;
    private ProgressBar progressBar;

    public LoadMyProgressBar(ProgressBar progressBar) {
        this.progress = MIN_LIMIT;

        this.progressBar = progressBar;
    }

    @Override
    public void run() {
        progress++;
        progressBar.setProgress(progress);
    }
}
