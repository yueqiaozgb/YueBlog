import {defineStore} from "pinia"
import defaultSetting from "../../setting.js"

const {title, logo, fixedHeader, sidebarLogo, defaultOpened} = defaultSetting

const useSettingStore = defineStore('setting', {
    state: () => ({
        title: title,
        logo: logo,
        fixedHeader: fixedHeader,
        sidebarLogo: sidebarLogo,
        defaultOpened: defaultOpened,
    })
})

export default useSettingStore
