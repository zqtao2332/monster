package cn.zqtao.monster.config.application;

import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Enumeration;

/**
 * 定时任务验证用户登录有效期
 */
@Slf4j
@Component
@EnableScheduling
public class SessionValidator {

    private final NBContext nbContext;

    @Autowired
    public SessionValidator(NBContext nbContext) {
        this.nbContext = nbContext;
    }

    @Scheduled(cron = "0 0/10 * * * ?")
    public void sessionValidate() {
        log.info("validate session in noteblog application task...");
        Enumeration<String> keys = nbContext.keys();
        while (keys.hasMoreElements()) {
            String uuid = keys.nextElement();
            NBSession session = nbContext.get(uuid);
            if (session != null) {
                if (session.isExpired()) {
                    String info = "delete session for id:[{}], at [{}]";
                    log.info(StrUtil.format(info, session.getId(), LocalDateTime.now()));
                    nbContext.removeSessionUser(uuid);
                }
            }
        }
    }

}
