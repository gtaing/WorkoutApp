package android.example.workoutapp;
import android.app.Activity;
import android.content.Intent;
import android.view.View;

import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;


public class DrawerUtil {


    private Drawer result;

    public static void getDrawer(final Activity activity, Toolbar toolbar) {
        //if you want to update the items at a later time it is recommended to keep it in a variable
        PrimaryDrawerItem item1 = new PrimaryDrawerItem().withIdentifier(1).withName("List exercises");
        PrimaryDrawerItem item2 = new PrimaryDrawerItem().withIdentifier(2).withName("Records");
        PrimaryDrawerItem item3 = new PrimaryDrawerItem().withIdentifier(3).withName("Programs");

        AccountHeader accountHeader = new AccountHeaderBuilder()
                .withActivity(activity)
                .withHeaderBackground(R.drawable.header_background)
                .build();


        //create the drawer and remember the `Drawer` result object
        Drawer result = new DrawerBuilder()
                .withActivity(activity)
                .withToolbar(toolbar)
                .withAccountHeader(accountHeader)
                .withActionBarDrawerToggle(true)
                .withActionBarDrawerToggleAnimated(true)
                .withCloseOnClick(true)
                .addDrawerItems(
                        item1,
                        new DividerDrawerItem(),
                        item2,
                        new DividerDrawerItem(),
                        item3
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        Intent intent = null;
                        if ((drawerItem.getIdentifier() == 1) && !(activity instanceof ListExercisesActivity)) {
                            intent = new Intent(activity, ListExercisesActivity.class);
                        } else if ((drawerItem.getIdentifier() == 2) && !(activity instanceof MainActivity)) {
                                intent = new Intent(activity, MainActivity.class);
                        } else if ((drawerItem.getIdentifier() == 3) && !(activity instanceof Exercise1Activity)) {
                            intent = new Intent(activity, Exercise1Activity.class);
                        }
                        if (intent != null) {
                            view.getContext().startActivity(intent);
                        }
                        return false;
                    }
                })
                .build();
        if (activity instanceof ListExercisesActivity) {
            result.setSelection(1);
        } else if (activity instanceof MainActivity) {
            result.setSelection(2);
        } else if (activity instanceof Exercise1Activity) {
            result.setSelection(3);
        }


    }



}

