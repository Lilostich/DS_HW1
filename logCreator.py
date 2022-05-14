import random
import syslog

SYSLOG_LEVELS = {
    syslog.LOG_EMERG: '[emerg]',
    syslog.LOG_ALERT: '[alert]',
    syslog.LOG_CRIT: '[crit]',
    syslog.LOG_ERR: '[error]',
    syslog.LOG_WARNING: '[warning]',
    syslog.LOG_NOTICE: '[notice]',
    syslog.LOG_INFO: '[info]',
    syslog.LOG_DEBUG: '[debug]',
}

def main():
    syslog.openlog(facility=syslog.LOG_SYSLOG)
    for i in range(20000):
        rnd_pr = random.choice([syslog.LOG_EMERG,
                                syslog.LOG_ALERT,
                                syslog.LOG_CRIT,
                                syslog.LOG_ERR,
                                syslog.LOG_WARNING,
                                syslog.LOG_NOTICE,
                                syslog.LOG_INFO,
                                syslog.LOG_DEBUG])
        syslog.syslog(rnd_pr, SYSLOG_LEVELS[rnd_pr]+': message number '+str(i))
    syslog.closelog()

if __name__ == '__main__':
    main()

