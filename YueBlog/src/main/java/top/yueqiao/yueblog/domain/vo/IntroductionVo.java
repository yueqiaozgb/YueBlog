package top.yueqiao.yueblog.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yueqiao
 */
@Data
@NoArgsConstructor
public class IntroductionVo {

    private String avatar;
    private String name;
    private String github;
    private String qq;
    private String bilibili;
    private String netease;
    private String email;

    private List<String> rollText = new ArrayList<>();
    private List<FavoriteVo> favorites = new ArrayList<>();

}
