package com.example.c.denglizimeijunqi.Function;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.c.denglizimeijunqi.MainActivity;
import com.example.c.denglizimeijunqi.R;
import com.sevenheaven.segmentcontrol.SegmentControl;

public class BangZhuActivity extends AppCompatActivity {
    private String[] data={"1. 使用准备\n" +
            "  1) 产品始终预热并保持住开关始终为ON的状态\n" +
            "  2) 主开关OFF或连接电源暂时不供给情况下需预热2小时再使用产品\n" +
            "  3) DC开关OFF也无妨，为了产品的寿命延长及保护始终保持ON状态\n" +
            "     - 间隔30分钟真空泵运转1分钟\n" +
            "     - 为防止门打开发生\n" +
            "  4) 长时间不使用产品的情况下实施自检后再使用\n" +
            "  5) 产品的门始终关闭\n" +
            "     - 门长时间开的话由于过热会发生扭曲\n",
            "2. 使用方法\n" +
            "  1) 被灭菌物洗涤后将水分完全去除\n" +
            "    - 不去除水分会造成泵的寿命变短\n" +
            "  2) 灭菌物包装\n" +
            "    - 灭菌袋子，灭菌布使用等离子灭菌器专用的，灭菌袋子的封口机温度设置为125℃\n" +
            "  3) 包装过的血灭菌物将门打开选择分布在灭菌室内部\n" +
            "    - 被灭菌物的量注意不要超过灭菌室内部的70%\n" +
            "  4) 关闭门按下LCD标示窗口的标准灭菌，表面灭菌，高级灭菌或表面灭菌\n",
            "3. 灭菌完成后,界面显示完成的文字时打印凭条\n" +
                    "   (打印纸显示灭菌积累次数,灭菌完成时间和终止时间，各进度的所需时间，灭菌是否成功）\n",
            "4. 确认灭菌完成后画面的下端按确认的按钮回到初始画面",
            "5. 灭菌取消\n" +
                    "  1) 取消方法： 画面的下端按取消中断进度\n" +
                    "     -  显示取消错误信息\n" +
                    "     -  为了去除灭菌剂进行干燥进度内部的电流后完成\n" +
                    "     -  打印出打印物\n" +
                    "    不按取消键拔掉电源的话之后灭菌室的电流灭菌剂\n" +
                    "    取消后一定使灭菌进度收尾完成\n" +
                    "  2) 灭菌进度取消的情况\n" +
                    "     - 放入不可灭菌的被灭菌物时\n" +
                    "     - 被灭菌物没有包装好时\n" +
                    "     - 被灭菌物的水分没有去除直接放进去时\n" +
                    "     - 使用者没注意没被灭菌物实行灭菌时\n" +
                    "     - 被灭菌物超过了灭菌仓的70%以上时   \n" +
                    "     - 灭菌进度进行中怀疑产品异常\n",
            "6.灭菌进度进行中注意勿触摸以上事由以外的事项"};
    private String[] data1={
            "1. 油、过滤器需要更换\n" +
                    "   发生原因：泵油及过滤器的更换周期达到的情况\n" +
                    "   产品可正常使用, 但不更换一直使用会成为造成产品损伤\n" +
                    "   措施：联系供应者更换油及过滤器。\n",
            "2. 仓门错误\n" +
                    "   发生原因：门开着的状态下施行灭菌\n" +
                    "   措施：关上门再灭菌\n",
            "3. 取消错误\n" +
                    "   发生原因：使用者按了取消键\n" +
                    "   措施：解决使用者的取消目的后再施行灭菌\n",
            "4. 注射加热器错误\n" +
                    "   原因：注射加热器发生异常\n" +
                    "   措施：产品主电源供给开始2小时以内到预热时主电源供给的状态下使用中发生的情况应及时向供应商联系\n",
            "5. 灭菌仓加热器错误\n" +
                    "   发生原因：灭菌仓加热器发生异常\n" +
                    "   措施：产品主电源供给开始2小时以内到预热时主电源供给的状态下使用中发生的情况应及时向供应商联系\n",
            "6. 更换过氧化氢\n" +
                    "   发生原因：产品内部灭菌剂不足时\n" +
                    "   措施：补充灭菌剂施行灭菌\n" +
                    "          (保管中灭菌剂没有的情况下向供应商联系)\n",
            "7. 过氧化氢供给错误\n" +
                    "   发生原因：灭菌进度进行中灭菌剂供应盒出现问题\n" +
                    "   措施：再施行灭菌也是反复如此的话联系供应商\n"};
    private String[] data2={
            "1. 被灭菌物如海绵，纸，木头，布等能吸水的物品绝对不允许包装灭菌\n" +
                    "   - 吸收灭菌剂, 灭菌室内部放入过多的灭菌剂\n" +
                    "   - 吸收灭菌剂, 灭菌进度完成后会残存并在手上有反应\n",
            "2.  灭菌前被灭菌物一定要洗涤并保持完全干燥\n" +
                    "   - 有水分的情况可能会发生过湿错误\n" +
                    "   - 真空泵投入过多的水分会减少泵的油和过滤器的寿命\n",
            "3. 灭菌时被灭菌物的量需在灭菌仓内部的70%以下施行灭菌\n" +
                    "   - 灭菌物放入太多进行灭菌的情况可能会降低灭菌能力或放入过多灭菌剂\n" +
                    "   - 被灭菌物放入灭菌仓时需要有多余空间, 最好达到手可进去的程度\n",
            "4. 灭菌袋及灭菌布应使用等离子专用\n" +
                    "   - 灭菌袋 封口机温度上线(EO-GAS:170℃, 低温等离子:125℃)\n" +
                    "            EO-GAS 及使用灭菌袋的话 根据入口的大小能通过的灭菌剂也有影响，由此灭菌效果也有影响。\n" +
                    "   - 灭菌布 使用专门符合低温等离子材质的灭菌布\n" +
                    "            绝对杜绝使用一面漏气的灭菌袋子  \n",
            "5. BI & CI 测试纸必须专门使用低温等离子灭菌器\n" +
                    "   - 如不是低温等离子专用保证不了灭菌能力\n",
            "6. BI必须在灭菌后48小时培养    \n" +
                    "   - 在60℃培养 48小时以上 （使用专用机器）  \n" +
                    "   - 确认培养结果   灭菌成功 : 维持标准紫色；灭菌失败: 培养完确认为黄色  \n",
            "7. 包装袋包装的灭菌物品的使用期限为6个月\n" +
                    "   - 未完全按照被灭菌物品的容量及使用周期来包装，保存期限会缩短\n" +
                    "   - 保存期间灭菌袋的封口部分开封或者灭菌袋破损时需再次灭菌进行保管\n",
            "8. 使用无纺布包装的灭菌物的使用期限为1个月\n" +
                    "   - 按照被灭菌物品的容量及使用周期来包装，也会缩短被保管的期限\n" +
                    "   - 保存期间无纺布包裹开口时需再次灭菌进行保管\n",
            "9. 无论是否使用灭菌仓，仓门必须始终关闭\n" +
                    "   - 仓门长时间打开，加热带需始终工作以保持灭菌仓内部的温度，可能会造成加热带出现故障\n",
            "10. 灭菌剂沾手后需及时用香皂清洗\n" +
                    "   - 灭菌剂沾手后变成灰色的话有可能会起气泡\n" +
                    "   - 灭菌剂沾手后皮肤变灰之前用香皂及时清洗会阻止反应的发生\n" +
                    "   - 时间长了灰色会下去，皮肤重新恢复成原来的状态（但是可能留下气泡破烂的痕迹）\n" +
                    "   - 应急措施要领\n" +
                    "    a. 进眼睛的话要一直用大量水清洗15分钟以上；及时接受医生的观察及治疗\n" +
                    "    b. 接触皮肤时: 脱下被污染的衣物和鞋子；及时使用大量的香皂水清洗皮肤；再次穿戴被污染的衣物和鞋子前需清洗；时接受医生的诊察及治疗\n" +
                    "    c. 吸入时: 远离灭菌剂；及时接受医生的诊察及治疗；注意呼吸困难时需要氧气供给；没有呼吸时实施人工呼吸\n" +
                    "    d. 误食时 : 饮足量温水，催吐洗胃；及时接受医生的诊察及治疗\n",
            "11. 大量冷金属成分的被灭菌物灭菌时会发生过湿故障\n" +
                    "   - 体积大的金属成分的灭菌物或大量金属成分的被灭菌物灭菌时，放入灭菌仓约5至10分钟预热后实施灭菌\n" +
                    "   - 大量冷金属成分的被灭菌物灭菌时会造成灭菌剂的凝缩使灭菌剂超量，灭菌完成后会有灭菌剂残留\n" +
                    "   - 不只是金属成分，还有大量冷的灭菌物进行灭菌时需要预热5~10分钟，既可以提高灭菌能力也可减少错误的发生 \n",
            "12. 灭菌剂一定要冷藏保管\n" +
                    "   - 灭菌剂瓶应加盖并保持排气，若长时间不能排放气体会造成灭菌剂的流出\n" +
                    "   - 震动冲击处理包装好的灭菌剂时会使灭菌剂流出\n"};

    private  ListView zhunbeilistView;
    private  ListView shuominglistView;
    private  ListView zhuyilistView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bang_zhu);
        Button button=(Button)findViewById(R.id.bangzhu_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(BangZhuActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(BangZhuActivity.this,android.R.layout.simple_list_item_1,data);
        zhunbeilistView=(ListView)findViewById(R.id.zhunbei_Listview);
        zhunbeilistView.setAdapter(adapter);
        ArrayAdapter<String> adapter1=new ArrayAdapter<String>(BangZhuActivity.this,android.R.layout.simple_list_item_1,data1);
        shuominglistView=(ListView)findViewById(R.id.shuoming_Listview);
        shuominglistView.setAdapter(adapter1);
        ArrayAdapter<String> adapter2=new ArrayAdapter<String>(BangZhuActivity.this,android.R.layout.simple_list_item_1,data2);
        zhuyilistView=(ListView)findViewById(R.id.zhuyi_Listview);
        zhuyilistView.setAdapter(adapter2);
        zhunbeilistView.setVisibility(View.VISIBLE);
        shuominglistView.setVisibility(View.GONE);
        zhuyilistView.setVisibility(View.GONE);
        SegmentControl segmentControl_horizon=(SegmentControl)findViewById(R.id.segment_control);
        segmentControl_horizon.setOnSegmentControlClickListener(new SegmentControl.OnSegmentControlClickListener() {
            @Override
            public void onSegmentControlClick(int index) {
                if (index==1){
                    zhunbeilistView.setVisibility(View.GONE);
                    shuominglistView.setVisibility(View.VISIBLE);
                    zhuyilistView.setVisibility(View.GONE);
                }else if (index==2){
                    zhunbeilistView.setVisibility(View.GONE);
                    shuominglistView.setVisibility(View.GONE);
                    zhuyilistView.setVisibility(View.VISIBLE);
                } else{
                    zhunbeilistView.setVisibility(View.VISIBLE);
                    shuominglistView.setVisibility(View.GONE);
                    zhuyilistView.setVisibility(View.GONE);
                }

            }
        });

    }
}
