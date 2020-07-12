<template>
  <div class="sample">
    <h1>{{ msg }} </h1>
    <el-button type="success" @click="getMsg">送信</el-button>
  </div>
</template>

<script>
import axios from 'axios'
export default {
  name: 'sample',
  data () {
    return {
      msg: ''
    }
  },
  methods: {
    getMsg: async function () {
      const res = await axios.get('http://localhost:8080/getMsg')
      console.log(res)
      this.msg = res.data.msg
      console.log(this.msg)
    }
  }
}
</script>
