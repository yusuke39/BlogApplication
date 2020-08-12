<template>
  <div>
    <form>
      <el-input placeholder="ブログタイトル" v-model="articleTitle"></el-input>
      <el-select v-model="blogCategory" placeholder="カテゴリー選択" class="blog-category">
        <el-option
          v-for="blogCategory in blogCategorys"
          :key="blogCategory.value"
          :label="blogCategory.label"
          :value="blogCategory.value">
        </el-option>
      </el-select>
      <mavon-editor
        language="ja"
        v-model="blogText"
        :counter="65535"
        :externalLink="mavonEditor.externalLink"
        :toolbars="mavonEditor.toolbars"
        placeholder="本文はこちらに入力してください"
        style="height: 700px;"
      ></mavon-editor>
      <el-button type="success" class="text-btn">記事を投稿する</el-button>
    </form>
  </div>
</template>

<script>
import mavonEditor from 'mavon-editor'
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
          },
          hljs_js: function () {
            return '/static/js/highlightjs/highlight.min.js'
          },
          katex_css: function () {
            return '/static/css/katex/katex.min.css'
          },
          katex_js: function () {
            return '/static/js/katex/katex.min.js'
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
      blogCategorys: [{
        value: '1',
        label: '旅行'
      }, {
        value: '2',
        label: '日常'
      }, {
        value: '3',
        label: 'エンタメ'
      }, {
        value: '4',
        label: '国内'
      }, {
        value: '5',
        label: '海外'
      }, {
        value: '6',
        label: 'その他'
      }],
      articleTitle: '',
      blogCategory: '',
      blogText: ''
    }
  },
  computed: {
    compiledMarkdownBody: function () {
      return mavonEditor(this.body)
    }
  }
}
</script>

<style scoped>
  .text-btn {
    margin-bottom: 50px;
    color: #ffffff;
    margin-left: 1299px
  }

  .blog-category {
    width: 1440px;
  }
</style>
