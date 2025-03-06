import { createPinia } from "pinia"

import useAppStore from "./modules/app"
import useSettingStore from "./modules/setting"

const pinia = createPinia()

pinia.use(({ store }) => {
    const initialState = JSON.parse(JSON.stringify(store.$state))
    store.$reset = () => {
        store.$patch(initialState)
    }
})

export default pinia

export { useAppStore, useSettingStore }
