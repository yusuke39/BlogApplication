<template>
  <div>
    <AdminHeader></AdminHeader>
    <form class="create-article-box">
      <el-input placeholder="ブログタイトル" v-model="articleTitle"></el-input>
      <el-tag
        :key="tag"
        v-for="tag in dynamicTags"
        closable
        :disable-transitions="false"
        @close="handleClose(tag)">
        {{tag}}
      </el-tag>
      <el-input
        class="input-new-tag"
        v-if="inputVisible"
        v-model="inputValue"
        ref="saveTagInput"
        size="mini"
        @keyup.enter.native="handleInputConfirm"
        @blur="handleInputConfirm"
      >
      </el-input>
      <el-button v-else class="button-new-tag" size="small" @click="showInput">+ タグをつける</el-button>
      <mavon-editor
        language="ja"
        v-model="blogText"
        :counter="65535"
        :toolbars="mavonEditor.toolbars"
        placeholder="本文はこちらに入力してください"
        style="height: 600px;"
      ></mavon-editor>
      <el-button type="success" class="text-btn">記事を投稿する</el-button>
    </form>
  </div>
</template>

<script>
import mavonEditor from 'mavon-editor'
import AdminHeader from './adminHeader'
import 'mavon-editor/dist/css/index.css'
import Vue from 'vue'
Vue.use(mavonEditor)
export default {
  data () {
    return {
      mavonEditor: {
        externalLink: {
          markdown_css: function () {
            return '/static/css/markdown/github-markdown.min.css'
          }
        },
        toolbars: {
          ol: true,
          ul: true,
          imagelink: true,
          readmodel: true,
          undo: true,
          redo: true,
          preview: true
        }
      },
      articleTitle: '',
      blogCategory: '',
      blogText: '',
      dynamicTags: [],
      inputVisible: false,
      inputValue: ''
    }
  },
  methods: {
    handleClose (tag) {
      this.dynamicTags.splice(this.dynamicTags.indexOf(tag), 1)
    },
    showInput () {
      this.inputVisible = true
      this.$nextTick(_ => {
        this.$refs.saveTagInput.$refs.input.focus()
      })
    },
    handleInputConfirm () {
      const inputValue = this.inputValue
      if (inputValue) {
        this.dynamicTags.push(inputValue)
      }
      this.inputVisible = false
      this.inputValue = ''
    }
  },
  computed: {
    compiledMarkdownBody: function () {
      return mavonEditor(this.body)
    }
  },
  components: {
    AdminHeader
  }
}
</script>

<style scoped>

  .create-article-box {
    margin-top: 10px;
  }

  .text-btn {
    margin-bottom: 50px;
    color: #ffffff;
    margin-left: 1299px
  }

  .blog-category {
    width: 1440px;
  }

  .el-tag + .el-tag {
    margin-left: 10px;
  }

  .button-new-tag {
    margin-left: 10px;
    height: 32px;
    line-height: 30px;
    padding-top: 0;
    padding-bottom: 0;
    background-color: #55C500;
    color: #ffffff;
  }

  .input-new-tag {
    width: 90px;
    margin-left: 10px;
    vertical-align: bottom;
  }
</style>
