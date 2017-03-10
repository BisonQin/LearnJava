package iodemo.pattern;

/**
 * 扩音器
 * 类与类之间的关系
 * 1.依赖：形参|局部变量
 * 2.关联：属性
 *      聚合：属性整体与部分不一致的生命周期  人与手
 *      组合：属性整体与部分一致的生命周期    人与大脑
 * 3.继承：父与子关系
 * 4.实现：接口与实现类关系
 * Created by Basil on 2016/3/14.
 */
public class Amplifier {
    private Voice voice;

    public Amplifier() {
    }

    public Amplifier(Voice voice) {
        this.voice = voice;
    }

    public void say(){
        System.out.println(voice.getVoice()*1000);
    }
}
