package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Banner banner;
    private RecyclerView recyclerView;
    private ContentAdapter contentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        banner = findViewById(R.id.banner);
        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                Toast.makeText(MainActivity.this, "点击了banner", Toast.LENGTH_SHORT).show();
            }
        });
        List<String> bannerImgPath = new ArrayList<>();
        bannerImgPath.add("https://goss3.cfp.cn/creative/vcg/800/new/VCG211165042753.jpg?x-oss-process=image/format,jpg/interlace,1");
        bannerImgPath.add("https://goss3.cfp.cn/creative/vcg/800/new/VCG211165042753.jpg?x-oss-process=image/format,jpg/interlace,1");
        bannerImgPath.add("https://goss3.cfp.cn/creative/vcg/800/new/VCG211165042753.jpg?x-oss-process=image/format,jpg/interlace,1");

        banner.setImages(bannerImgPath)
                .setDelayTime(4000)
                //.setBannerAnimation(Transformer.Stack)
                .setIndicatorGravity(BannerConfig.CENTER)
                .setImageLoader(new ImageLoader() {
                    @Override
                    public void displayImage(Context context, Object path, ImageView imageView) {
                        //因为此banner接近正方形, 不用使用 R.mipmap.icon_default_banner占位图, 会导致闪屏
                        Glide.with(MainActivity.this).load((String) path).into(imageView);
                    }
                })
                .start();


        ContentModel m1 = new ContentModel();
        m1.setContent("医患关系，是影响护士职业幸福感的第一大因素。护理部主任万长秀坦言，护士是医疗服务的终端，病人对所有医疗环节的不满，最终发泄口都是护士。去年《中国护士群体发展现状调查报告》显示：41.2%的护士在近一年内，遭受过患者或家属的过激行为；在各种职业伤害类型中，他们的心理创伤比例最高。\\\" +\\n\" +\n" +
                "                \"                        \\\"去年年底，中国社会福利基金会在了解到许晴的情况后，曾与湖北省中医院“护士心理解压站”取得联系，希望通过心理疏导帮小姑娘走出阴影。然而遗憾的是，许晴一直没有主动联系他们。\\\" +\\n\" +\n" +
                "                \"                        \\\"医患关系，是影响护士职业幸福感的第一大因素。护理部主任万长秀坦言，护士是医疗服务的终端，病人对所有医疗环节的不满，最终发泄口都是护士。去年《中国护士群体发展现状调查报告》显示：41.2%的护士在近一年内，遭受过患者或家属的过激行为；在各种职业伤害类型中，他们的心理创伤比例最高。\\\\\\\" +\\\\n\\\" +\\n\" +\n" +
                "                \"                        \\\"                        \\\\\\\"去年年底，中国社会福利基金会在了解到许晴的情况后，曾与湖北省中医院“护士心理解压站”取得联系，希望通过心理疏导帮小姑娘走出阴影。然而遗憾的是，许晴一直没有主动联系他们。\\\" +\\n\" +\n" +
                "                \"                        \\\"医患关系，是影响护士职业幸福感的第一大因素。护理部主任万长秀坦言，护士是医疗服务的终端，病人对所有医疗环节的不满，最终发泄口都是护士。去年《中国护士群体发展现状调查报告》显示：41.2%的护士在近一年内，遭受过患者或家属的过激行为；在各种职业伤害类型中，他们的心理创伤比例最高。\\\\\\\" +\\\\n\\\" +\\n\" +\n" +
                "                \"                        \\\"                        \\\\\\\"去年年底，中国社会福利基金会在了解到许晴的情况后，曾与湖北省中医院“护士心理解压站”取得联系，希望通过心理疏导帮小姑娘走出阴影。然而遗憾的是，许晴一直没有主动联系他们。\\\" +\\n\" +\n" +
                "                \"                        \\\"医患关系，是影响护士职业幸福感的第一大因素。护理部主任万长秀坦言，护士是医疗服务的终端，病人对所有医疗环节的不满，最终发泄口都是护士。去年《中国护士群体发展现状调查报告》显示：41.2%的护士在近一年内，遭受过患者或家属的过激行为；在各种职业伤害类型中，他们的心理创伤比例最高。\\\\\\\" +\\\\n\\\" +\\n\" +\n" +
                "                \"                        \\\"                        \\\\\\\"去年年底，中国社会福利基金会在了解到许晴的情况后，曾与湖北省中医院“护士心理解压站”取得联系，希望通过心理疏导帮小姑娘走出阴影。然而遗憾的是，许晴一直没有主动联系他们。\\\" +\\n\" +\n" +
                "                \"                        \\\"医患关系，是影响护士职业幸福感的第一大因素。护理部主任万长秀坦言\" end");
        m1.setExpanded(false);

        ContentModel m2 = new ContentModel();
        m2.setContent("\t\t\t\t\t医患关系，是影响护士职业幸福感的第一大因素。护理部主任万长秀坦言，护士是医疗服务的终端，病人对所有医疗环节的不满，最终发泄口都是护士。去年《中国护士群体发展现状调查报告》显示：41.2%的护士在近一年内，遭受过患者或家属的过激行为；在各种职业伤害类型中，他们的心理创伤比例最高。去年年底，中国社会福利基金会在了解到许晴的情况后，曾与湖北省中医院“护士心理解压站”取得联系，希望通过心理疏导帮小姑娘走出阴影。然而遗憾的是，许晴一直没有主动联系他们。end");
        m2.setExpanded(false);

        ContentModel m3 = new ContentModel();
        m3.setContent("\t\t\t\t\t医患关系，是影响护士职业幸福感的第一大因素。护理部主任万长秀坦言，护士是医疗服务的终端，病人对所有医疗环节的不满，最终发泄口都是护士。去年《中国护士群体发展现状调查报告》显示：41.2%的护士在近一年内，遭受过患者或家属的过激行为；在各种职业伤害类型中，他们的心理创伤比例最高。去年年底，中国社会福利基金会在了解到许晴的情况后，曾与湖北省中医院“护士心理解压站”取得联系，希望通过心理疏导帮小姑娘走出阴影。然而遗憾的是，许晴一直没有主动联系他们。" +
                "医患关系，是影响护士职业幸福感的第一大因素。护理部主任万长秀坦言，护士是医疗服务的终端，病人对所有医疗环节的不满，最终发泄口都是护士。去年《中国护士群体发展现状调查报告》显示：41.2%的护士在近一年内，遭受过患者或家属的过激行为；在各种职业伤害类型中，他们的心理创伤比例最高。去年年底，中国社会福利基金会在了解到许晴的情况后，曾与湖北省中医院“护士心理解压站”取得联系，希望通过心理疏导帮小姑娘走出阴影。然而遗憾的是，许晴一直没有主动联系他们。end");
        m3.setExpanded(false);

        ContentModel m4 = new ContentModel();
        m4.setContent("\t\t\t\t\t医患关系，是影响护士职业幸福感的第一大因素。护理部主任万长秀坦言，护士是医疗服务的终端，病人对所有医疗环节的不满，最终发泄口都是护士。去年《中国护士群体发展现状调查报告》显示：41.2%的护士在近一年内，遭受过患者或家属的过激行为；在各种职业伤害类型中，他们的心理创伤比例最高。去年年底，中国社会福利基金会在了解到许晴的情况后，曾与湖北省中医院“护士心理解压站”取得联系，希望通过心理疏导帮小姑娘走出阴影。然而遗憾的是，许晴一直没有主动联系他们。" +
                "医患关系，是影响护士职业幸福感的第一大因素。护理部主任万长秀坦言，护士是医疗服务的终端，病人对所有医疗环节的不满，最终发泄口都是护士。去年《中国护士群体发展现状调查报告》显示：41.2%的护士在近一年内，遭受过患者或家属的过激行为；在各种职业伤害类型中，他们的心理创伤比例最高。去年年底，中国社会福利基金会在了解到许晴的情况后，曾与湖北省中医院“护士心理解压站”取得联系，希望通过心理疏导帮小姑娘走出阴影。然而遗憾的是，许晴一直没有主动联系他们。end");
        m4.setExpanded(false);

        ContentModel m5 = new ContentModel();
        m5.setContent("\t\t\t\t\t医患关系，是影响护士职业幸福感的第一大因素。护理部主任万长秀坦言，护士是医疗服务的终端，病人对所有医疗环节的不满，最终发泄口都是护士。去年《中国护士群体发展现状调查报告》显示：41.2%的护士在近一年内，遭受过患者或家属的过激行为；在各种职业伤害类型中，他们的心理创伤比例最高。去年年底，中国社会福利基金会在了解到许晴的情况后，曾与湖北省中医院“护士心理解压站”取得联系，希望通过心理疏导帮小姑娘走出阴影。然而遗憾的是，许晴一直没有主动联系他们。" +
                "医患关系，是影响护士职业幸福感的第一大因素。护理部主任万长秀坦言，护士是医疗服务的终端，病人对所有医疗环节的不满，最终发泄口都是护士。去年《中国护士群体发展现状调查报告》显示：41.2%的护士在近一年内，遭受过患者或家属的过激行为；在各种职业伤害类型中，他们的心理创伤比例最高。去年年底，中国社会福利基金会在了解到许晴的情况后，曾与湖北省中医院“护士心理解压站”取得联系，希望通过心理疏导帮小姑娘走出阴影。然而遗憾的是，许晴一直没有主动联系他们。end");
        m5.setExpanded(false);

        ContentModel m6 = new ContentModel();
        m6.setContent("\t\t\t\t\t医患关系，是影响护士职业幸福感的第一大因素。护理部主任万长秀坦言，护士是医疗服务的终端，病人对所有医疗环节的不满，最终发泄口都是护士。去年《中国护士群体发展现状调查报告》显示：41.2%的护士在近一年内，遭受过患者或家属的过激行为；在各种职业伤害类型中，他们的心理创伤比例最高。去年年底，中国社会福利基金会在了解到许晴的情况后，曾与湖北省中医院“护士心理解压站”取得联系，希望通过心理疏导帮小姑娘走出阴影。然而遗憾的是，许晴一直没有主动联系他们。" +
                "医患关系，是影响护士职业幸福感的第一大因素。护理部主任万长秀坦言，护士是医疗服务的终端，病人对所有医疗环节的不满，最终发泄口都是护士。去年《中国护士群体发展现状调查报告》显示：41.2%的护士在近一年内，遭受过患者或家属的过激行为；在各种职业伤害类型中，他们的心理创伤比例最高。去年年底，中国社会福利基金会在了解到许晴的情况后，曾与湖北省中医院“护士心理解压站”取得联系，希望通过心理疏导帮小姑娘走出阴影。然而遗憾的是，许晴一直没有主动联系他们。end");
        m6.setExpanded(false);

        ContentModel m7 = new ContentModel();
        m7.setContent("\t\t\t\t\t医患关系，是影响护士职业幸福感的第一大因素。护理部主任万长秀坦言，护士是医疗服务的终端，病人对所有医疗环节的不满，最终发泄口都是护士。去年《中国护士群体发展现状调查报告》显示：41.2%的护士在近一年内，遭受过患者或家属的过激行为；在各种职业伤害类型中，他们的心理创伤比例最高。去年年底，中国社会福利基金会在了解到许晴的情况后，曾与湖北省中医院“护士心理解压站”取得联系，希望通过心理疏导帮小姑娘走出阴影。然而遗憾的是，许晴一直没有主动联系他们。" +
                "医患关系，是影响护士职业幸福感的第一大因素。护理部主任万长秀坦言，护士是医疗服务的终端，病人对所有医疗环节的不满，最终发泄口都是护士。去年《中国护士群体发展现状调查报告》显示：41.2%的护士在近一年内，遭受过患者或家属的过激行为；在各种职业伤害类型中，他们的心理创伤比例最高。去年年底，中国社会福利基金会在了解到许晴的情况后，曾与湖北省中医院“护士心理解压站”取得联系，希望通过心理疏导帮小姑娘走出阴影。然而遗憾的是，许晴一直没有主动联系他们。end");
        m7.setExpanded(false);

        List<ContentModel> data = new ArrayList<>();
        data.add(m1);
        data.add(m2);
        data.add(m3);
        data.add(m4);
        data.add(m5);
        data.add(m6);
        data.add(m7);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        contentAdapter = new ContentAdapter(data);
        recyclerView.setAdapter(contentAdapter);

    }
}
