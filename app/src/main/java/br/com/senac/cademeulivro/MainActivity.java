package br.com.senac.cademeulivro;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import br.com.senac.cademeulivro.activities.edit.ObraDetalhadaEditActivity;
import br.com.senac.cademeulivro.activities.tabs.ContainerListFragment;
import br.com.senac.cademeulivro.activities.tabs.tab_ObrasFragment;
import br.com.senac.cademeulivro.activities.tabs.tab_RecomendadosFragment;
import br.com.senac.cademeulivro.activities.tabs.tab_TagsFragment;


/**
 * Created by joaos on 22/04/2017.
 */

public class MainActivity extends AppCompatActivity {


    private SectionsPagerAdapter mSectionsPagerAdapter;
    private FloatingActionButton fab;

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        fab = (FloatingActionButton) findViewById(R.id.fab);

    }




    public void fabFuncao(View v){

        CharSequence opcoes[] = new CharSequence[] {"Manualmente", "Escanear ISBN"};

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Cadastrar");
        builder.setItems(opcoes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                if(which==0){
                    Intent intent=new Intent(MainActivity.this,ObraDetalhadaEditActivity.class);
                    startActivity(intent);

                }else{
                    //Escanear isbn
                }

            }
        });
        builder.show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            switch (position) {

                case 0:
                    ContainerListFragment tabContainers=new ContainerListFragment();
                    return tabContainers;
                case 1:
                    tab_ObrasFragment tabObras=new tab_ObrasFragment();
                    return tabObras;
                case 2:
                    tab_TagsFragment tabTags=new tab_TagsFragment();
                    return tabTags;
                case 3:
                    tab_RecomendadosFragment tabRecomendados=new tab_RecomendadosFragment();
                    return tabRecomendados;

                default:
                    return null;

            }

        }

        @Override
        public int getCount() {
            // Show 4 total pages.
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Containers";
                case 1:
                    return "Obras";
                case 2:
                    return "Tags";
                case 3:
                    return "Recomendados";
            }
            return null;
        }

    }

}
