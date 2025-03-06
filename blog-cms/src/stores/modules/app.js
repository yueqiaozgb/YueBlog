import { defineStore } from "pinia"
import {ref} from "vue";

const useAppStore = defineStore('app', () => {
    let device = ref('desktop')
    let sidebar = ref({
        opened: true,
        withoutAnimation: false
    })
    return {device, sidebar}
})

export default useAppStore
