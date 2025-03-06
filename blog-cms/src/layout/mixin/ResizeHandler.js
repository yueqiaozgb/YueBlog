import { useAppStore } from '../../stores/index.js'
import {storeToRefs} from "pinia";

const { body } = document
const WIDTH = 992 // refer to Bootstrap's responsive design

export default{
    watch: {
        $route(route) {
            const app = useAppStore()
            let { device, sidebar } = storeToRefs(app)
            if (device === 'mobile' && sidebar.opened) {
                sidebar.withoutAnimation = false
            }
        }
    },
    beforeMount() {
        window.addEventListener('resize', this.$_resizeHandler)
    },
    beforeDestroy() {
        window.removeEventListener('resize', this.$_resizeHandler)
    },
    mounted() {
        const isMobile = this.$_isMobile()
        if (isMobile) {
            const app = useAppStore()
            let { device, sidebar } = storeToRefs(app)
            device = 'mobile'
            sidebar.withoutAnimation = true
        }
    },
    methods: {
        // use $_ for mixins properties
        // https://vuejs.org/v2/style-guide/index.html#Private-property-names-essential
        $_isMobile() {
            const rect = body.getBoundingClientRect()
            return rect.width - 1 < WIDTH
        },
        $_resizeHandler() {
            if (!document.hidden) {
                const app = useAppStore()
                let { device, sidebar } = storeToRefs(app)
                if (this.$_isMobile()) {
                    device = 'mobile'
                    sidebar.withoutAnimation = true
                } else {
                    device = 'desktop'
                }
            }
        }
    }
}
