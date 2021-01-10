package android.example.workoutapp;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.VideoView;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;

public class Exercise_pushups extends AppCompatActivity {
    private VideoView videoView;
    private int position = 0;
    private MediaController mediaController;
    private Button buttonPlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_video);
        this.videoView = (VideoView) findViewById(R.id.videoView);
        buttonPlay = (Button) findViewById(R.id.buttonPlay);
        // Set the media controller buttons
        if (this.mediaController == null) {
            this.mediaController = new MediaController(Exercise_pushups.this);

            // Set the videoView that acts as the anchor for the MediaController.
            this.mediaController.setAnchorView(videoView);

            // Set MediaController for VideoView
            this.videoView.setMediaController(mediaController);
        }
        // When the video file ready for playback.
        this.videoView.setOnPreparedListener(new OnPreparedListener() {

            public void onPrepared(MediaPlayer mediaPlayer) {

                videoView.seekTo(position);
                if (position == 0) {
                    videoView.start();
                }

                // When video Screen change size.
                mediaPlayer.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() {
                    @Override
                    public void onVideoSizeChanged(MediaPlayer mp, int width, int height) {

                        // Re-Set the videoView that acts as the anchor for the MediaController
                        mediaController.setAnchorView(videoView);
                    }
                });
            }
        });
        this.buttonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // "myvideo.mp4" in directory "raw".
                String resName = VideoViewUtils.RAW_VIDEO_SAMPLE_PUSH_UP;
                VideoViewUtils.playRawVideo(Exercise_pushups.this, videoView, resName);
            }
        });
    }
}
