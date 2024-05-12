Vue.createApp({
    data() {
        return {
            firstTitle: '開發者',
            lastName:'john'
        }
    },
    computed:{
        SendMassage:{
            get(){
                return this.firstTitle + "/"+this.lastName
            },
            set(value){
                var arr = value;
            }
        }
    }
}).mount("#vue_title");


//組合生日
Vue.createApp({
    data() {
        return {
            years: '',
            months:'',
            days:''
        }
    },
    computed:{
        combineDate:{
            get(){
                return this.years+this.months+this.days
            },
            set(value){

            }

        }
    }
}).mount("#vue_birthday")
